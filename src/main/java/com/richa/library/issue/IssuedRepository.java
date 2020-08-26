/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richa.library.issue;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer
 */
@Repository
public interface IssuedRepository  extends JpaRepository<Issued, Integer>{
//@Query("select s.id from Issued s")
   // List<Object> getSchoolIdAndName();
    List<Issued> findByUserUid(int uid);
}
