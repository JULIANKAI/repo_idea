package com.lagou.service;

import com.lagou.domain.Test;
import org.aspectj.weaver.ast.Var;

import java.util.List;

public interface testService {
    public List<Test> findAllTest();
}
