package com.example.demo.converter;

import com.example.demo.bean.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by wuxg-a on 2018/2/28.
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConverter(){
        super(new MediaType("application", "x-wisely",  Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> obj, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tmpArray = temp.split("-");
        return new DemoObj(new Long(tmpArray[0]), tmpArray[1]);
    }

    @Override
    protected void writeInternal(DemoObj o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + o.getId() + "=" + o.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
