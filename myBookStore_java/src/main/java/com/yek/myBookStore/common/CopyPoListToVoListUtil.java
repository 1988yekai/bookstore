package com.yek.myBookStore.common;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/10/17
 */
public class CopyPoListToVoListUtil {
    public static List copyList (List <? extends Object> poList , Class voClass){
        List voList=new ArrayList();
        Object voObj =null;
        for(Object poObj:poList){
            try {
                voObj = voClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                BeanUtils.copyProperties(poObj, voObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            voList.add(voObj);
        }
        return voList;
    }
}
