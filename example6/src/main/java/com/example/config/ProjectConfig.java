package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.example.beans", "com.example.implementations", "com.example.services" })
public class ProjectConfig {

}
