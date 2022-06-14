import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName comboBoxModel
 * @Description TODO
 * @Author xpower
 * @Date 2022/5/18 8:47
 * @Version 1.0
 */
public class comboBoxModel extends listModel implements ComboBoxModel<BigDecimal> {
   private int selectedIndex;

    public comboBoxModel(double start, double end, double step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
            if(anItem instanceof BigDecimal){
                BigDecimal anItem1 = (BigDecimal) anItem;
                //求出索引位置
                selectedIndex = anItem1.subtract(super.start).divide(super.step, 2, RoundingMode.HALF_DOWN).intValue();
            }
    }

    @Override
    public Object getSelectedItem() {
        //获取选中条目
        return super.step.multiply(BigDecimal.valueOf(selectedIndex)).add(super.start).setScale(2,RoundingMode.HALF_DOWN);
    }
}
