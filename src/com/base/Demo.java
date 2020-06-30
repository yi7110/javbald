package com.base;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * com.base
 *
 * @author Liuzf
 * @date 2020-06-26 12:59:26
 */

    class StaticStuff
{
          static int x = 10;

             static {
                 System.out.println("1");
                 x += 5; }

        public static void main(String args[])
        {
               System.out.println("x = " + StaticStuff .x);
            }
          static
            {
                System.out.println("2");
                x /= 3; }
        }

