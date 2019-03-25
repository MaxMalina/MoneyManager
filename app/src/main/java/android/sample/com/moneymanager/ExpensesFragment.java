package android.sample.com.moneymanager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.sample.com.moneymanager.databinding.FragmentExpensesBinding;
import android.sample.com.moneymanager.databinding.FragmentIncomesBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;

public class ExpensesFragment extends Fragment {

    private FragmentExpensesBinding binding;

    public static ExpensesFragment newInstance() {
        return new ExpensesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExpensesBinding.inflate(inflater, container,false);

        generateData();

        return binding.getRoot();
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<SliceValue>();

        values.add(new SliceValue(51, Color.parseColor("#3497FD")));
        values.add(new SliceValue(24, Color.parseColor("#665EFF")));
        values.add(new SliceValue(23, Color.parseColor("#3ACCE1")));

        PieChartData data = new PieChartData(values);
        data.setHasLabels(false);
        data.setHasLabelsOnlyForSelected(false);
        data.setHasLabelsOutside(true);
        data.setHasCenterCircle(true);

        data.setSlicesSpacing(1);
        data.setCenterCircleScale(0.85f);

        data.setCenterText2Color(Color.parseColor("#454F63"));
        data.setCenterText2("10300₴");

        data.setCenterText1Color(Color.parseColor("#9A9A9A"));
        data.setCenterText1("Spended");

        data.setValueLabelBackgroundColor(Color.parseColor("#FFFFFF"));
        data.setValueLabelsTextColor(Color.parseColor("#000000"));

        // Get font size from dimens.xml and convert it to sp(library uses sp values).
        //magic
        data.setCenterText2FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity, ChartUtils.dp2px(getResources().getDisplayMetrics().scaledDensity, 34)));

        data.setCenterText1FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity, ChartUtils.dp2px(getResources().getDisplayMetrics().scaledDensity, 12)));


        binding.chart.setPieChartData(data);
        binding.chart.getChartData().setValueLabelBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}
