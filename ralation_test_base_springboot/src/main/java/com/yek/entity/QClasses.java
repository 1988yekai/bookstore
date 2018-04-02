package com.yek.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClasses is a Querydsl query type for Classes
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClasses extends EntityPathBase<Classes> {

    private static final long serialVersionUID = 1731588471L;

    public static final QClasses classes = new QClasses("classes");

    public final NumberPath<Long> cid = createNumber("cid", Long.class);

    public final StringPath name = createString("name");

    public final SetPath<Student, QStudent> students = this.<Student, QStudent>createSet("students", Student.class, QStudent.class, PathInits.DIRECT2);

    public QClasses(String variable) {
        super(Classes.class, forVariable(variable));
    }

    public QClasses(Path<? extends Classes> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClasses(PathMetadata metadata) {
        super(Classes.class, metadata);
    }

}

