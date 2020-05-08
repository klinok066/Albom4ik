package com.example.albom4ik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView1);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int mYear = year;
                int mMonth = month;
                int mDay = dayOfMonth;
                String selectedDate = new StringBuilder().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" ").toString();
                Toast.makeText(getApplicationContext(), selectedDate, Toast.LENGTH_LONG).show();
            }
            })
    ;}

    static class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

        private LayoutInflater inflater;
        private List<Phone> phones;

        DataAdapter(Context context, List<Phone> phones) {
            this.phones = phones;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
            final Phone phone = phones.get(position);
            holder.imageView.setImageResource(phone.getImage());
            holder.nameView.setText(phone.getName());
            holder.companyView.setText(phone.getCompany());
            holder.itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(v.getContext(),  PhoneDetails.class);
                    intent.putExtra("image_resourse", phone.getImage());
                    intent.putExtra("phone_name", phone.getName());
                    v.getContext().startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return phones.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final View itemLayout;
            final ImageView imageView;
            final TextView nameView, companyView;
            ViewHolder(View view){
                super(view);
                itemLayout = view.findViewById(R.id.item_layout);
                imageView = (ImageView)view.findViewById(R.id.image);
                nameView = (TextView) view.findViewById(R.id.name);
                companyView = (TextView) view.findViewById(R.id.company);
            }
        }
    }

    public static class MainActivity extends AppCompatActivity {

        List<Phone> phones = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setInitialData();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
            // создаем адаптер
            DataAdapter adapter = new DataAdapter(this, phones);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            // устанавливаем для списка адаптер
            recyclerView.setAdapter(adapter);
        }


        private void setInitialData(){

            phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.mate8));
            phones.add(new Phone ("Elite z3", "HP", R.drawable.mate8));
            phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.mate8));
            phones.add(new Phone ("LG G 5", "LG", R.drawable.mate8));
            phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.mate8));
            phones.add(new Phone ("Elite z3", "HP", R.drawable.mate8));
            phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.mate8));
            phones.add(new Phone ("LG G 5", "LG", R.drawable.mate8));
            phones.add(new Phone ("Huawei P10", "Huawei", R.drawable.mate8));
            phones.add(new Phone ("Elite z3", "HP", R.drawable.mate8));
            phones.add(new Phone ("Galaxy S8", "Samsung", R.drawable.mate8));
            phones.add(new Phone ("LG G 5", "LG", R.drawable.mate8));
        }
    }

    public static class Phone {

        private String name;
        private String company;
        private int image;

        public Phone(String name, String company, int image){

            this.name=name;
            this.company = company;
            this.image = image;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return this.company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getImage() {
            return this.image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

    public static class PhoneDetails extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_phone_details);

            Intent intent = getIntent();
            String phoneName = intent.getStringExtra("phone_name");
            String image = intent.getStringExtra("phone_name");
        }
    }
}

