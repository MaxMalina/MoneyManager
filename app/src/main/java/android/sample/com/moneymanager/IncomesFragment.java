package android.sample.com.moneymanager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;

import android.sample.com.moneymanager.databinding.FragmentIncomesBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class IncomesFragment extends Fragment {

    private FragmentIncomesBinding binding;

    public static IncomesFragment newInstance() {
        return new IncomesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIncomesBinding.inflate(inflater, container,false);

        generateData();

        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<SliceValue>();

        values.add(new SliceValue(51, Color.parseColor("#3497FD")));
        values.add(new SliceValue(49, Color.parseColor("#665EFF")));

        PieChartData data = new PieChartData(values);
        data.setHasLabels(false);
        data.setHasLabelsOnlyForSelected(false);
        data.setHasLabelsOutside(true);
        data.setHasCenterCircle(true);

        data.setSlicesSpacing(1);
        data.setCenterCircleScale(0.85f);

        data.setCenterText1Color(Color.parseColor("#454F63"));
        data.setCenterText1("20000₴");

        data.setCenterText2Color(Color.parseColor("#9A9A9A"));
        data.setCenterText2("Get");

        data.setValueLabelBackgroundColor(Color.parseColor("#FFFFFF"));
        data.setValueLabelsTextColor(Color.parseColor("#000000"));

        // Get font size from dimens.xml and convert it to sp(library uses sp values).
        //magic
        data.setCenterText1FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity, ChartUtils.dp2px(getResources().getDisplayMetrics().scaledDensity, 34)));

        data.setCenterText2FontSize(ChartUtils.px2sp(getResources().getDisplayMetrics().scaledDensity, ChartUtils.dp2px(getResources().getDisplayMetrics().scaledDensity, 12)));


        binding.chart.setPieChartData(data);
        binding.chart.getChartData().setValueLabelBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}
