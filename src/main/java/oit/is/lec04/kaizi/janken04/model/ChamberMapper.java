package oit.is.lec04.kaizi.janken04.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ChamberMapper {

  @Select("SELECT id,userName,chamberName from chamber where id = #{id}")
  Chamber selectById(int id);

  @Insert("INSERT INTO chamber (userName,chamberName) VALUES (#{userName},#{chamberName});")
  @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
  void insertChamber(Chamber chamber);

  @Select("SELECT * from chamber where chamberName = #{chamberName}")
  ArrayList<Chamber> selectAllByChamberName(String chamberName);

  @Select("SELECT chamber.userName,chamber.chamberName,userinfo.age,userinfo.height, from chamber JOIN userinfo ON chamber.userName=userinfo.userName;")
  ArrayList<ChamberUser> selectAllChamberUser();

  @Insert("INSERT INTO userinfo (userName,age,height) VALUES (#{userName},#{age},#{height});")
  void insertUserInfo(UserInfo userinfo);

}
