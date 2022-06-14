import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractList;

/**
 * @ClassName listModel
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/18 8:47
 * @Version 1.0
 */
public class listModel extends AbstractListModel<BigDecimal> {
    //开始值
    BigDecimal start;
    //结束值
    BigDecimal end;
    //步长
    BigDecimal step;

    public listModel(double start, double end, double step) {
        this.start = new BigDecimal(start);
        this.end = new BigDecimal(end);
        this.step = new BigDecimal(step);
    }

    @Override
    public int getSize() {
        int count =end.subtract(start).divide(step,2, RoundingMode.HALF_DOWN).intValue();

        return count + 1;
    }

    @Override
    public BigDecimal getElementAt(int index) {

        return step.multiply(BigDecimal.valueOf(index)).add(start).setScale(2,RoundingMode.HALF_DOWN);
    }
}
