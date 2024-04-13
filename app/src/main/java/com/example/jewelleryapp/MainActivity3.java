package com.example.jewelleryapp;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jewelleryapp.databinding.ActivityMain3Binding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements MyItemAdapter.OnItemClickListener{

    ActivityMain3Binding activityMain3Binding;
    MyItemAdapter myItemAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        activityMain3Binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(activityMain3Binding.getRoot());

        JSONObject jsonObject = loadJSONFromAsset(this, "item_data.json");

        ArrayList<HomeItemModel> arrMainActivity3Items = new ArrayList<>();

        Intent intent = getIntent();
        int num = intent.getIntExtra("category_item_id",-1);
        Log.d(TAG, "onCreate: "+num);
        activityMain3Binding.recyclerActivity3Id.setLayoutManager(new GridLayoutManager(this,2));
        String x="";
        switch(num){
            case 0:
                x="rings";
                break;
            case 1:
                x="necklaces";
                break;
            case 2:
                x="earrings";
                break;
            case 3:
                x="pendants";
                break;
            case 4:
                x="chains";
                break;
            case 5:
                x="bracelets";
                break;
            case 6:
                x="watches";
                break;
        }
        if (jsonObject != null) {
            try {
//                Log.d(TAG, "onCreate: "+x);
                JSONArray array = jsonObject.getJSONArray(x);
                for(int i=0;i<=array.length();i++){
                    JSONObject object = array.getJSONObject(i);
//                    int image = getResources().getIdentifier(object.getString("image"+i+1), "drawable", this.getPackageName());
                    String imageName = object.getString("image");
                    Log.d(TAG, "onCreate: "+imageName);
                    int imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    String name = object.getString("name");
                    String price = object.getString("price");
                    arrMainActivity3Items.add(new HomeItemModel(imageResourceId,name,price));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "onCreate: "+jsonObject);
        } else {
            Log.e("JSON Error", "Failed to load JSON object");
        }
        myItemAdapter =new MyItemAdapter(this,arrMainActivity3Items,this);
        activityMain3Binding.recyclerActivity3Id.setAdapter(myItemAdapter);

    }

    @Override
    public void onItemClick(HomeItemModel item) {
        Intent i = new Intent(MainActivity3.this, ItemDescription.class);
        i.putExtra("item_image", item.img);
        i.putExtra("item_name", item.name);
        i.putExtra("item_price", item.price);
        startActivity(i);
    }

    public JSONObject loadJSONFromAsset(Context context, String filename) {
        JSONObject json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            Log.d(TAG, "loadJSONFromAsset: inputstream");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            Log.d(TAG, "loadJSONFromAsset: close");
            String jsonString = new String(buffer, "UTF-8");
            json = new JSONObject(jsonString);
            Log.d(TAG, "loadJSONFromAsset: jsonstring to object");
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
            Log.e("JSON Error", "Error loading JSON from asset: " + filename);
        }
        return json;
    }
}