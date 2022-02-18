/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quyentq.mathutil.test;

import com.quyentq.mathutil.core.MathUtil;
import static com.quyentq.mathutil.core.MathUtil.getFactorial;
import java.io.Serializable;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author PhongVu
 */
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    // ta cần test thử hàm getF() bên code chính chạy đúng không
    //rõ ràng ta phải đưa data cho hàm, xong xem nó trả về gì
    //so sánh kết luận hàm đúng sai
    // 3 việc:  chuẩn bị data, đưa data vào hàm (gọi hàm)
    //                      kết luận đúng sai
    //done ở bên MathUtilsTest rồi NHƯNG
    
    //0!, O -> 1
    //1!, 1 -> 1
    //2!, 2 -> 2        bộ dữ liệu test
    //3!, 3 -> 6`       lưu table trong SQLServer. Exel, .CSV
    //5!, 5 -> 120 
    // mảng 2 chiều [7][2]
    //
    
    // hoc cách viết code tách đám data ra khỏi các câu lệnh
    //getF(), ko mixed. Tất cả các framework UnitTest của 
    // mọi NNLT đều làm được!!!
    
    //hàm trả về mảng 2 chiều kiểu Object
    //vì các Framework chơi với object không à, mảng số nguyên
    //phải hiểu là Object, tức là chơi với Wrapper Class nếu
    //mảng số ...
    //Wrapper Class: Integer(int), Long (long), Character (char)
    
    //Báo máy JVM đây là data nguồn !! dùng nhồi asser
    @Parameterized.Parameters
    public static Object [][] initData(){
        int a[] = {2, 4 ,6, 8};
        
        return new Integer[][]{
                                   {0, 1},
                                   {1, 1},
                                   {2, 2},
                                   {3, 6},
                                   {6, 720},
        };
    }
    
    //cần trích mảng con ra để được cặp value input/expected
    @Parameterized.Parameter(value = 0) //map cột 0
    public int input;
    
    @Parameterized.Parameter(value = 1) //map cột 1
    public int expected;
    
    @Test 
    public void testFactotialGinvenValidArgumentReturnWell() {
       
        //long actual = MathUtil.getFactorial(input);
        assertEquals(expected, getFactorial(input));
        
    }
    

    //DDT tách data cần test ra 1 chỗ. Sau đó lấy từng miếng data
    //mồi/nhồi/lắp/map vào trong chỗ gọi hàm, chỗ assert()
    //tách và nhồi vào -> làm hoài như vậy cho các bộ data
    
}
