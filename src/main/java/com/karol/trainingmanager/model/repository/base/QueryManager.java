package com.karol.trainingmanager.model.repository.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class QueryManager {
    @AllArgsConstructor
    @Getter
    public enum UpdateQuery {
        SET_DISCONTINUE_DATE("update {0} set DISCONTINUE_DATE = getDate() where {1} = ?0"),
        SET_SINGLE_PARAMETER("update {0} set {1} = {2} where {3} = ?0");
        private final String value;
    }

    @AllArgsConstructor
    @Getter
    public enum SelectQuery {
        GET_NEXTVAL_ID("select max({0}) from {1}"),
        GET_SINGLE_VALUE("select {0} from {1} where {2} = ?0"),
        GET_COMPANY_NAME_AND_ID("select party.PARTY_ID, party.PARTY_NAME from RIPARTY party join STAT_RPRT_RQST_COMP rqest on rqest.PARTY_ID = party.PARTY_ID where rqest.STAT_RPRT_RQST_ID = ?0"),
        BY_TABLE_NAME_AND_COLUMN_NAME("select {1} from {0}"),
        GET_MANUAL_ADJS_LINKED_MANUAL_ADJST_AMOUNTS("select lnk.LINK_SYS_OBJ_VAL as valCode, val.OBJ_VAL_MEANING as valMeaning FROM RITLINKVAL lnk\n" +
                "  join RITOBJVAL val\n" +
                "  on val.OBJ_VAL_CODE = lnk.LINK_SYS_OBJ_VAL AND\n" +
                "     val.SYS_OBJECT_CODE = lnk.LINK_SYS_OBJECT \n" +
                "where lnk.SYS_OBJECT_CODE = 999998\n" +
                "  and lnk.OBJ_VAL_CODE =:adjustmentType\n" +
                "order by val.VALUE_ORDER "),
        GET_UNIQUE_SECTION_REF_NO("select distinct SECTION_REF_NO from RISECTION");
        private final String value;
    }

    @AllArgsConstructor
    @Getter
    public enum ValidationQuery {
        VALIDATE_SR_MAP_HEADER_EXIST("select * from SR_MAP_HEADER as S where S.SUB_SYSTEM = :subSystem and EXTRACT_TYPE = :extractType and coalesce(BUSINESS_IND, '') = :businessIndication " +
                "and REPOSITORY_ID = :repositoryId and REPO_FIN_STMT_ID = :repoFinStmtId and (S.DISCONTINUE_DATE is null or S.DISCONTINUE_DATE > getDate())");

        private final String value;
    }
}
