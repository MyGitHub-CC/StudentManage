package com.situ.student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.situ.student.Util.JDBCUtil;
import com.situ.student.dao.IStudentDao;
import com.situ.student.entity.Student;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public boolean add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO student(NAME,age,gender) VALUES (?,?,?);";
		boolean result = false;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getGender());
			int resultCount = preparedStatement.executeUpdate();
			if (resultCount > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public boolean update(Student student) {
		return false;
	}

	@Override
	public boolean findById(int id) {
		return false;
	}

	@Override
	public List<Student> findAll() {
		return null;
	}

}
