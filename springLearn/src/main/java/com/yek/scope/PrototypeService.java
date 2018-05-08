package com.yek.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-08.
 */
@Service
@Scope("prototype")
public class PrototypeService {
}
