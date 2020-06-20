## 函数demo
CREATE FUNCTION avg(num1 SMALLINT UNSIGNED ,num2 SMALLINT UNSIGNED)
RETURNS FLOAT(3,2) 
RETURN (num1+num2)/2;

create function addUser(username varchar(20),age tinyint(3) unsigned)
returns tinyint(3) unsigned
begin
insert tb1(username,age) values(username,age);
return (select max(age) from tb1);
end 
————————————————
原文链接：https://blog.csdn.net/u013457382/article/details/51155412
## 触发器demo
查看触发器 show triggers
创建只有一个执行语句的触发器
create trigger trig_book after insert 
           on t_book for each row 
           update t_bookType set bookNum = bookNum+1 where new.bookTypeId = t_booktype.id;
CREATE
    TRIGGER `jony_keer`.`ins_account` AFTER INSERT
    ON `jony_keer`.`t_account`
    FOR EACH ROW 
    BEGIN
    INSERT INTO `t_user`(`userid`,`cellphone`,`account_psd`)  VALUES  (new.`account_id`,new.`cellphone`,new.`account_psd`);
    END$$
原文链接：https://blog.csdn.net/weixin_40256864/article/details/81196285
创建有多条执行语句的触发器
DELIMITER |
create trigger trig_book2 after delete 
    on t_book for each row 
    begin 
          update t_bookType set bookNum = bookNum-1 where old.bookTypeId=t_booktype.id;
          insert into t_log values(null,NOW(),'在book表里删除了一条数据');
          delete from t_test where old.bookTypeId = t_test.id;
    end
|
DELIMITER ;
## 存储过程以及调用demo
-- 秒杀执行储存过程
DELIMITER $$ -- console ; 转换为
$$
-- 定义储存过程
-- 参数： in 参数   out输出参数
-- row_count() 返回上一条修改类型sql(delete,insert,update)的影响行数
-- row_count:0:未修改数据 ; >0:表示修改的行数； <0:sql错误
CREATE PROCEDURE `seckill`.`execute_seckill`
  (IN v_seckill_id BIGINT, IN v_phone BIGINT,
   IN v_kill_time  TIMESTAMP, OUT r_result INT)
  BEGIN
    DECLARE insert_count INT DEFAULT 0;
    START TRANSACTION;
    INSERT IGNORE INTO success_killed
    (seckill_id, user_phone, create_time)
    VALUES (v_seckill_id, v_phone, v_kill_time);
    SELECT row_count()
    INTO insert_count;
    IF (insert_count = 0)
    THEN
      ROLLBACK;
      SET r_result = -1;
    ELSEIF (insert_count < 0)
      THEN
        ROLLBACK;
        SET r_result = -2;
    ELSE
      UPDATE seckill
      SET number = number - 1
      WHERE seckill_id = v_seckill_id
            AND end_time > v_kill_time
            AND start_time < v_kill_time
            AND number > 0;
      SELECT row_count()
      INTO insert_count;
      IF (insert_count = 0)
      THEN
        ROLLBACK;
        SET r_result = 0;
      ELSEIF (insert_count < 0)
        THEN
          ROLLBACK;
          SET r_result = -2;
      ELSE
        COMMIT;
        SET r_result = 1;

      END IF;
    END IF;
  END;
$$
--  储存过程定义结束
DELIMITER ;
SET @r_result = -3;
--  执行储存过程
CALL execute_seckill(1003, 13502178891, now(), @r_result);
-- 获取结果
SELECT @r_result;

<!--调用储存过程-->
    <select id="killByProcedure" statementType="CALLABLE">
        CALL execute_seckill(
                #{seckillId,jdbcType=BIGINT,mode=IN},
                #{phone,jdbcType=BIGINT,mode=IN},
                #{killTime,jdbcType=TIMESTAMP,mode=IN},
                #{result,jdbcType=INTEGER,mode=OUT}
        )
    </select>
    
     public void testFunction(){  
            //{？= call <procedure-name>[<arg1>,<arg2>...]}  
            String sql = "{call selectAge(?)}";  
            Connection conn = null;  
            CallableStatement call = null;  
            try {  
                //得到数据库连接  
                conn = JDBCUtils.getConnection();  
                  
                //通过数据库连接创建statement  
                call = conn.prepareCall(sql);  
                  
                //对于输出参数，声明  
                call.registerOutParameter(1, OracleTypes.NUMBER);  
                  
                //对于输入参数，赋值  
                call.setInt(2, 3);  
                  
                //执行调用  
                call.execute();  
                  
                            //获取返回的结果  
                int age = call.getInt(1);  
                  
                System.out.println("该用户年龄："+age);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }finally{  
                JDBCUtils.release(conn, call, null);  
            }  
        }  
        
      ## sql函数  
        空空Ryan
        SQL中 decode() 函数介绍
        decode() 函数的语法：
        
        1 Select decode（columnname，值1,翻译值1,值2,翻译值2,...值n,翻译值n,缺省值）
        2 
        3 From talbename
        4 
        5 Where …
        其中：columnname为要选择的table中所定义的column；
        
        　　 缺省值可以是你要选择的column name本身，也可以是你想定义的其他值，比如Other等；
        
        主要作用：相当于IF语句， 将查询结果翻译成其他值。（即以其他形式表现出来）。
        
         
        
        举例说明：
        
        现定义一table名为output，其中定义两个column分别为monthid（var型）和sale（number型），若sale值=1000时翻译为D，=2000时翻译为C，=3000时翻译为B，=4000时翻译为A，如是其他值则翻译为Other：
        
        Select monthid , decode (sale,1000,'D',2000,'C',3000,'B',4000,'A',’Other’) sale from output
        若只与一个值进行比较：
        
        Select monthid ,decode（sale， NULL，‘---’，sale） sale from output
         
        
        decode中可使用其他函数，如nvl()函数或sign()函数等：
        
        　　NVL(EXPR1,EXPR2)
        
        　　若EXPR1是NULL,则返回EXPR2,否则返回EXPR1。
        
        SELECT NAME,NVL(TO_CHAR(COMM),'NOT APPLICATION') FROM TABLE1;
        如果用到decode函数中：
        
        select monthid,decode(nvl(sale,6000),6000,'NG','OK') from output;
         
        
        　　sign()函数根据某个值是0、正数还是负数，分别返回0、1、-1，
        
        用如下的SQL语句取较小值：
        
        select monthid,decode(sign(sale-6000),-1,sale,6000) from output;
         
         
         一 concat()函数
         
         1、功能：将多个字符串连接成一个字符串。
         
         2、语法：concat(str1, str2,...)　　
         
         返回结果为连接参数产生的字符串，如果有任何一个参数为null，则返回值为null。
         
         3、语法：concat(str1, seperator,str2,seperator,...)
         
         返回结果为连接参数产生的字符串并且有分隔符，如果有任何一个参数为null，则返回值为null。
         
          
         
         二 concat_ws()函数
         
         1、功能：和concat()一样，将多个字符串连接成一个字符串，但是可以一次性指定分隔符（concat_ws就是concat with separator）
         
         2、语法：concat_ws(separator, str1, str2, ...)
         
         说明：第一个参数指定分隔符。需要注意的是分隔符不能为null，如果为null，则返回结果为null。
         
          
         
         三 group_concat()函数
         
         1、功能：将group by产生的同一个分组中的值连接起来，返回一个字符串结果。
         
         2、语法：group_concat( [distinct] 要连接的字段 [order by 排序字段 asc/desc  ] [separator '分隔符'] )
         
         说明：通过使用distinct可以排除重复值；如果希望对结果中的值进行排序，可以使用order by子句；separator是一个字符串值，缺省为一个逗号。
         
         ROUND（number[,decimals]）
         
         其中：number 待做截取处理的数值；
         　　　decimals 指明需保留小数点后面的位数，可选项。需要注意的是，和trunc函数不同，对截取的数字要四舍五入。
         
         　　　　　　　　1. 忽略它则截去所有的小数部分，并四舍五入；
         
         　　　　　　　　2. 如果y不为整数则截取y整数部分；
         
         　　　　　　　　3. 如果为负数则表示从小数点开始左边的位数，相应整数数字用0填充，小数被去掉。
         
         实例：
         
         复制代码
          1 SQL>   select   round(1234.5678,3)   from   dual;
          2 ROUND(1234.5678,3)
          3 ——————
          4 1234.568
          5 
          6 SQL>   select   round(1234.5678,0)   from   dual;
          7 ROUND(1234.5678,0)
          8 ——————
          9 1235
         10 
         11 SQL>   select   round(1234.5678,-2)   from   dual;
         12 ROUND(1234.5678,-2)
         13 ——————-
         14 1200
         15 
         16 SQL>   select   round(5555.6666,2.1)   from   dual;
         17 ROUND(5555.6666,2.1)
         18 ——————-
         19 5555.67
         复制代码
          
         
         TRUNC(for number) 函数处理number型数字
         
         语法格式：TRUNC（number[,decimals]）
         
         其中： number 待做截取处理的数值；
         
         　　　 decimals 指明需保留小数点后面的位数，可选项，截取时并不对数据进行四舍五入。
         
         　　　　　　　　　1. 忽略它则截去所有的小数部分；
         
         　　　　　　　　　2. 如果y不为整数则截取y整数部分；
         
         　　　　　　　　　3. 如果为负数则表示从小数点开始左边的位数，相应整数数字用0填充，小数被去掉。
         
         实例：
         
         复制代码
         1 select trunc(123.458) from dual --123
         2 
         3 select trunc(123.458,1) from dual --123.4
         4 
         5 select trunc(123.458,-1) from dual --120
         6 
         7 select trunc(5555.66666,2.1) -- 5555.66
         复制代码
          
         
         trunc(for dates) 函数处理日期
         
         语法格式：TRUNC（date[,fmt]）
         
         其中：date 一个日期值；fmt 日期格式。
         
         该日期将按指定的日期格式截取；忽略它则由最近的日期截取。
         
         实例：
         
         复制代码
          1 select trunc(sysdate) from dual;  --2017/2/13,返回当前时间
          2 
          3 select trunc(sysdate,'yy') from dual;  --2017/1/1,返回当年第一天
          4 
          5 select trunc(sysdate,'mm') from dual;  --2017/2/1,返回当月的第一天
          6 
          7 select trunc(sysdate,'d') from dual;  --2017/2/12,返回当前星期的第一天，即星期天
          8 
          9 select trunc(sysdate,'dd') from dual;  --2017/2/13,返回当前日期,今天是2017/2/13
         10 
         11 select trunc(sysdate ,'HH24') from dual;  --2017/2/13 15:00:00,返回本小时的开始时间
         12 
         13 select trunc(sysdate ,'MI') from dual;  --2017/2/13 15:13:00,返回本分钟的开始时间，TRUNC()函数没有秒的精确