package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity,ID extends Long> implements DataRepository<T,ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;
    
    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T t, T t1) {
            return Long.compare(t.getId(),t1.getId());
        }
    };

    @Override
    public T save(T data) {

        if(Objects.isNull(data)){
            throw new RuntimeException("No Data");
        }

        var prevData = dataList.stream()
                        .filter(it->{
                            return it.getId().equals(data.getId());
                        }).findFirst();

        if(prevData.isPresent()){
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }
    
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
        
        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return dataList.stream().sorted(sort).collect(Collectors.toList());
    }
}
