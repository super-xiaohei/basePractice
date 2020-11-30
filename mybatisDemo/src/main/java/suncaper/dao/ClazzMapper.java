package suncaper.dao;

import suncaper.domain.Clazz;

/**
 * @author zyq
 * @date 2020/11/4 - 15:31
 */
public interface ClazzMapper {
    Clazz selectWithTeacherByClazzId(int i);

    Clazz selectWithTeacherAndStudentByClazzId(int id);
}
