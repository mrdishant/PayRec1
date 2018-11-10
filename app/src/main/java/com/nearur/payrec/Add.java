
package com.nearur.payrec;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Add extends AppCompatActivity {

    EditText edname;
    EditText edphone;
    EditText edalternate;
    EditText edaddress;
    EditText edamount;
    EditText eddate;

    Button button;
    Customer c;

    ContentResolver resolver;

    void init(){
        edname=(EditText)findViewById(R.id.editTextname);
        edphone=(EditText)findViewById(R.id.editTextphone);
        edalternate=(EditText)findViewById(R.id.editTextalternate);
        eddate=(EditText)findViewById(R.id.editTextdate);
        Date d=new Date();
        SimpleDateFormat fr=new SimpleDateFormat("dd/MM/yyyy");
        eddate.setText(fr.format(d).toString());
        edamount=(EditText)findViewById(R.id.editTextamount);
        edaddress=(EditText)findViewById(R.id.editTextaddress);
        resolver=getContentResolver();
        c=new Customer();

        button=(Button)findViewById(R.id.button);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c.name=edname.getText().toString().trim();
                c.mobile=edphone.getText().toString().trim();
                c.alternate=edalternate.getText().toString().trim();
                c.amount=edamount.getText().toString().trim();
                c.address=edaddress.getText().toString().trim();
                c.date=eddate.getText().toString().trim();

                insert(c);
                finish();
            }
        });

    }

    void insert(Customer customer){

        ContentValues values=new ContentValues();
        values.put(Util.Name,customer.name);

        values.put(Util.Name,customer.name);
        values.put(Util.Mobile,customer.mobile);
        values.put(Util.Address,customer.address);
        values.put(Util.Amount,customer.amount);
        values.put(Util.Alternate,customer.alternate);
        values.put(Util.Date,customer.date);

        Uri x=resolver.insert(Util.u,values);

        Toast.makeText(this,"Record Inserted "+x.getLastPathSegment(),Toast.LENGTH_LONG).show();
    }
}
