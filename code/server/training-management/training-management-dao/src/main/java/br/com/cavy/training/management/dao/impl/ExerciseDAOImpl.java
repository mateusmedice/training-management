package br.com.cavy.training.management.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.dao.ExerciseDAO;
import br.com.cavy.training.management.model.Exercise;

@Repository
public class ExerciseDAOImpl extends DAOImpl<Exercise, String> implements ExerciseDAO {

}
