import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Task89 {
    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

    /**
     <h3>
    Нужно воспользоваться свойством отражения:</br>
     Если мы уже знаем последовательность Грея для n-1 (которая содержит 2^(n-1) чисел), то последовательность для n строится так:
     </h3>
     <ol>
     <li><h5>Берем старую последовательность для n-1 и выписываем её слева направо. В начале каждого числа этой части ставим 0 (что фактически не меняет число, но теперь оно стало n-битным).</h5></li>
     <li><h5>Отражаем старую последовательность (идем по ней справа налево). В начале каждого числа этой части ставим 1.</h5></li>
     </ol>

     */
    public static List<Integer> grayCode(int n) {
        List<Integer> sequens = new ArrayList();
        // добавляем решение для n == 1
        sequens.add(0);
        sequens.add(1);
        if (n == 1) return sequens;
        // если n > 1, то по алгоритму добавляем отражение несколько раз
        for (int pow = 1; pow < n; pow++) {
            List<Integer> newHalf = new ArrayList();
            int plus = 1<<pow;
            for (int i = sequens.size() - 1; i >= 0; i--) {
                newHalf.add(sequens.get(i) + plus);
            }
            sequens.addAll(newHalf);
        }
        return sequens;
    }

    /**
    <h3>Ещё быстрее делается через формулу: g(i) = i XOR i>>1</h3>
     <h5>g(i) - i-е число последовательности Грея, (0 <= i <= n^2 - 1)</h5>
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> sequens = new ArrayList();
        for (int pow = 0; pow < 1<<n; pow++) {
            sequens.add(pow ^ pow>>1);
        }
        return sequens;
    }
}
