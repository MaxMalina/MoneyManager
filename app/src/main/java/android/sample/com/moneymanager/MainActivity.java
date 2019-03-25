package android.sample.com.moneymanager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.sample.com.moneymanager.databinding.ActivityMainBinding;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        ReadableBottomBar.ItemSelectListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.navigation.setOnItemSelectListener(this::onItemSelected);

        binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_outline_add_24px));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, IncomesFragment.newInstance())
                .commit();
    }

    @Override
    public void onItemSelected(int i) {
        switch (i) {
            case 0:
                replaceFragment(R.string.title_incomes, R.drawable.ic_outline_add_24px, IncomesFragment.newInstance());
                break;
            case 1:
                replaceFragment(R.string.title_expenses, R.drawable.ic_outline_add_24px, ExpensesFragment.newInstance());
                break;
            case 2:
                replaceFragment(R.string.title_budget, R.drawable.ic_edit_24px, BudgetFragment.newInstance());
                break;
        }
    }

    private void replaceFragment(@StringRes int titleRes, @DrawableRes int drawableRes, Fragment fragment) {
        binding.message.setText(titleRes);
        binding.fab.setImageDrawable(ContextCompat.getDrawable(this, drawableRes));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
