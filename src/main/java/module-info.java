module com.netronic {
    requires spring.context;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires spring.jdbc;
    requires java.sql;
    requires spring.orm;
    requires spring.beans;
    requires net.bytebuddy;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires com.fasterxml.jackson.databind;
    requires static lombok;
    exports com.netronic;

    opens com.netronic.controller;
    opens com.netronic.config;
    opens com.netronic.dao.impl;
    opens com.netronic.service;
    opens com.netronic.service.impl;
    opens com.netronic.service.mapper;
    opens com.netronic.dto;
    opens com.netronic.model;
    opens com.netronic.model.location;
}
