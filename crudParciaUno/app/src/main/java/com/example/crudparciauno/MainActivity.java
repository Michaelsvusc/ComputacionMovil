package com.example.crudparciauno;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.crudparciauno.interfaces.CrudEmpleadoInterface;
import com.example.crudparciauno.model.Empleados;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Empleados> empleados;
    CrudEmpleadoInterface cruempleado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAll();
        //guardar();
    }

    /*private void guardar() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleados> call = cruempleado.guardar();
        call.enqueue(new Callback<Empleados>() {
            @Override
            public void onResponse(Call<Empleados> call, Response<Empleados> response) {
                if(!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
                empleados = response.body();
                empleados.forEach(p -> Log.i("Empleados: ",p.toString()));
            }

            @Override
            public void onFailure(Call<Empleados> call, Throwable t) {
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }*/

    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleados>> call = cruempleado.getAll();
        call.enqueue(new Callback<List<Empleados>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Empleados>> call, Response<List<Empleados>> response) {
                if(!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }
                empleados = response.body();
                empleados.forEach(p -> Log.i("Empleados: ",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Empleados>> call, Throwable t) {
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }
}