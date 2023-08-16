package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.beans.*;

@Configuration
@ComponentScan(basePackages = { "com.example.services", "com.example.aspects", "com.example.beans" })
@EnableAspectJAutoProxy
public class ProjectConfig {

}
