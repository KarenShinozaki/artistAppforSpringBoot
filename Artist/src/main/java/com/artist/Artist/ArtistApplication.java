package com.artist.Artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.PrintStream;
import java.sql.*;
import java.util.*;

@SpringBootApplication
public class ArtistApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistApplication.class, args);

		Connection conn = null;
		try {
			// JDBCドライバをロード
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベース接続情報を設定
			String url = "jdbc:mysql://localhost/artist_db";
			String user = "root";
			String password = "root";

			// データベースに接続を試みる
			conn = DriverManager.getConnection(url, user, password);

			// 接続が成功した場合は、メッセージを表示する
			System.out.println("Connected to database.");

		} catch (SQLException e) {
			// 接続が失敗した場合は、エラーメッセージを表示する
			PrintStream out = System.out;
			System.out.println(out);

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
