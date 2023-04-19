package com.example.crudparciauno.interfaces;

import com.example.crudparciauno.model.Empleados;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CrudEmpleadoInterface {
    @GET("/consultarAll")
    Call<List<Empleados>> getAll();

    @POST("/guardar")
    Call<List<Empleados>> guardar();
}
