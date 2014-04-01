/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmap4u.data;

import java.util.Map.Entry;

/**
 *
 * @author hadrbolec
 */
public class EntryImpl<K, V> implements Entry<K, V> {

    private K key = null;

    private V value = null;

    public EntryImpl() {
    }

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return this.value;
    }

}
