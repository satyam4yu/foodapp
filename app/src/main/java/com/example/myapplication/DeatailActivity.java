package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityDeatailBinding;

public class DeatailActivity extends AppCompatActivity {
    ActivityDeatailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDeatailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final DBHelper helper =new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1){

            final int image=getIntent().getIntExtra("image",0);
            final int price=Integer.parseInt(getIntent().getStringExtra("price"));
            final String name= getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");




        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.nameLbl.setText(name);
        binding.detailDesicription.setText(description);




        binding.button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               boolean isInsetred =  helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        description,
                        name,
                       1
                );
               if(isInsetred)
                   Toast.makeText( DeatailActivity.this,"Data Success", Toast.LENGTH_SHORT).show();
               else
                   Toast.makeText( DeatailActivity.this,"ERROR", Toast.LENGTH_SHORT).show();

            }




        });


    }
    else{
       final int id=getIntent().getIntExtra("id",0);
        Cursor cursor=helper.getOrderById(id);
       final int image=cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.nameLbl.setText(cursor.getString(6));
            binding.detailDesicription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.button3.setText("Update Now");
            binding.button3.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                   boolean isUpdated= helper.updateOrder(
                            binding.nameBox.getText().toString(),

                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),
                            image,
                            binding.detailDesicription.getText().toString(),
                            binding.nameLbl.getText().toString(),1,id




                            );
                    if(isUpdated)
                        Toast.makeText( DeatailActivity.this,"Data Success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText( DeatailActivity.this,"ERROR", Toast.LENGTH_SHORT).show();



                }
            });



    }


    }
}