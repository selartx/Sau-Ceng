/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testthread;

/**
 *
 * @author shiza
 */
public class Test {

    public void test() {
        int BUFFER_SIZE = 5, in = 0, count = 0, next_produced = 0;
        int next_consumed = 0, out = 0;
        int[] buffer = new int[BUFFER_SIZE];

        while (true) {
            /* produce an item in next produced */
            while (count == BUFFER_SIZE) {

            };
            /* do nothing */
            buffer[in] = next_produced;
            in = (in + 1) % BUFFER_SIZE;
            count++;
        }

        while (true) {
            while (count == 0) ;
            /* do nothing */
            next_consumed = buffer[out];
            out = (out + 1) % BUFFER_SIZE;
            count--;
            /* consume the item in next consumed */
        }
    }
}
