package michael.com.criminalintent;

import android.support.v4.app.Fragment;


/**
 * Created by Mikhail on 8/18/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_masterdetail;
    }
}
