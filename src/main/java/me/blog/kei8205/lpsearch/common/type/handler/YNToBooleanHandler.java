package me.blog.kei8205.lpsearch.common.type.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.common.base.Strings;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class YNToBooleanHandler extends BaseTypeHandler<Boolean> {

	private String convertBooleanToChar(Boolean target) {
		if (target == null) {
			return "N";
		}
		return target ? "Y" : "N";
	}

	private Boolean convertYNCharToBoolean(String target) {
		if (Strings.isNullOrEmpty(target)) {
			return false;
		}
		return "Y".equalsIgnoreCase(target.trim()) ? true : false;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		ps.setString(i, convertBooleanToChar(parameter));
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		String result = rs.getString(columnName);
		return convertYNCharToBoolean(result);
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String result = rs.getString(columnIndex);
		return convertYNCharToBoolean(result);
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String result = cs.getString(columnIndex);
		return convertYNCharToBoolean(result);
	}
}
