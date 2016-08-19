package michael.com.criminalintent.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import michael.com.criminalintent.R;
import michael.com.criminalintent.model.Crime;

/**
 * Created by Mikhail on 8/18/16.
 */
public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.CrimeHolder> {

    private List<Crime> mCrimes;


    public CrimeAdapter(List<Crime> crimes) {
        this.mCrimes = crimes;
    }

    public class CrimeHolder extends RecyclerView.ViewHolder {

        private Crime mCrime;

        @BindView(R.id.list_item_crime_title_text_view)
        public TextView mTitleTextView;
        @BindView(R.id.list_item_crime_date_text_view)
        public TextView mDateTextView;
        @BindView(R.id.list_item_crime_solved_check_box)
        public CheckBox mSolvedCheckBox;

        public CrimeHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }

    @Override
    public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_crime, parent, false);
        return new CrimeHolder(view);
    }

    @Override
    public void onBindViewHolder(CrimeHolder holder, int position) {

        Crime crime = mCrimes.get(position);
        bindCrime(holder,crime);

    }

    public void bindCrime(CrimeHolder holder, Crime crime) {

        holder.mCrime = crime;
        holder.mTitleTextView.setText(crime.getTitle());
        holder.mDateTextView.setText(crime.getDate().toString());
        holder.mSolvedCheckBox.setChecked(crime.isSolved());

    }

    @Override
    public int getItemCount() {
        return mCrimes.size();
    }


}