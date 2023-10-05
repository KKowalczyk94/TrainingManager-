package com.karol.trainingmanager.model.repository.base;

import com.karol.trainingmanager.model.entities.base.SrMapHeader;
import com.karol.trainingmanager.model.entities.base.StatRprtRqstCompDto;
import com.karol.trainingmanager.services.base.DictionaryMetadata;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
@RequiredArgsConstructor
public class CustomRepository<T, K> {

    private EntityManager entityManager;
    private NamedParameterJdbcTemplate template;

    public K setDiscontinueDate(Class clazz, K id) throws ObjectNotFoundException {
        if (clazz.isAnnotationPresent(Table.class)) {
            final Query nativeQuery = entityManager.createNativeQuery(MessageFormat
                    .format(QueryManager.UpdateQuery.SET_DISCONTINUE_DATE.getValue(),
                            Reflections.getTableName(clazz),
                            Reflections.getJoinedColumnName(clazz))).setParameter(0, id);
            nativeQuery.executeUpdate();
        }
        return id;
    }

    public K setDiscontinueDate(String targetClass, String idCilumnName, K id) {
        final Query nativeQuery = entityManager.createNativeQuery(MessageFormat
                        .format(QueryManager.UpdateQuery.SET_DISCONTINUE_DATE.getValue(),
                                targetClass,
                                idCilumnName))
                .setParameter(0, id);
        nativeQuery.executeUpdate();
        return id;
    }

    public Object generateId (String idColumnName, String targetEntity) {
        final Query nativeQuery = entityManager.createNativeQuery(MessageFormat
                .format(QueryManager.SelectQuery.GET_NEXTVAL_ID.getValue(),
                idColumnName,
                targetEntity));
        Long generatedId = (Long) nativeQuery.getSingleResult();
        return Optional.ofNullable(generatedId).isPresent() ? generatedId : 0;
    }

    public boolean validateSfMapHeaderAlreadyExist(SrMapHeader header) {
        Query query = entityManager.createNativeQuery(QueryManager.ValidationQuery.VALIDATE_SR_MAP_HEADER_EXIST.getValue(), SrMapHeader.class)
                .setParameter("subSystem", header.getSubSystem())
                .setParameter("extractType", header.getExtractType())
                .setParameter("businessIndication", header.getBusinessIndication() == null ? "" : header.getBusinessIndication())
                .setParameter("repositoryId", header.getRepositoryId())
                .setParameter("repoFinStmtId", header.getRepoFinStmtId());
        return !(query.getResultList().isEmpty());
    }

    public List<String> findGlFindStatById(Integer statementid) {
        final Query query = entityManager.createNativeQuery(MessageFormat.format(QueryManager.SelectQuery.GET_SINGLE_VALUE.getValue(), TableFields.GL_FIN_STMT_NAME, TableNames.RIGLSTMT.getTableName(), TableFields.GL_FIN_STMT_ID))
                .setParameter(0, statementid);
        return query.getResultList();
    }

    public List<StatRprtRqstCompDto> findByStatRprtRqstId(Long freginKeyId) {
        final Query query = entityManager.createNativeQuery(MessageFormat.format(QueryManager.SelectQuery.GET_COMPANY_NAME_AND_ID.getValue(), StatRprtRqstCompDto.class)).setParameter(0, freginKeyId);
        return query.getResultList();
    }

    public List<T> findListByTableNameAndColumnName(String tableName, String tableColumn) {
        final Query query = entityManager.createNativeQuery(MessageFormat.format(QueryManager.SelectQuery.BY_TABLE_NAME_AND_COLUMN_NAME.getValue(), tableName, tableColumn));
        return query.getResultList();
    }

    public List<String> findAllUniqueSectionRefNo() {
        Query query = entityManager.createNativeQuery(MessageFormat.format(QueryManager.SelectQuery.GET_UNIQUE_SECTION_REF_NO.getValue(), String.class));
        return query.getResultList();
    }

    public List<DictionaryMetadata> getManualAdjtLinksToManualAdjsAmount(String adjustmentType) {
        return template.query(QueryManager.SelectQuery.GET_MANUAL_ADJS_LINKED_MANUAL_ADJST_AMOUNTS.getValue(),
                Collections.singletonMap("adjustmentType", adjustmentType),
                new RowMapper<DictionaryMetadata>() {
            @Override
            public DictionaryMetadata mapRow(ResultSet resultSet, int i) throws SQLException {
                return DictionaryMetadata.builder()
                        .valCode(resultSet.getString("valCode"))
                        .valMeaning(resultSet.getString("valMeaning"))
                        .build();
            }
        });
    }
}
