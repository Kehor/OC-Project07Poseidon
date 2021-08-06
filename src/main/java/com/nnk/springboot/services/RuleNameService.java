package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RuleNameService {

    @Autowired
    private RuleNameRepository ruleNameRepository;
    /**
     *
     * @return all RuleName in a List<RuleName>
     */
    public List<RuleName> findAllRuleName() {
        List<RuleName> ruleNameList = ruleNameRepository.findAll();
        return ruleNameList;
    }
    /**
     *
     * @param id int
     * @return RuleName
     */
    public RuleName findOneRuleNameById(int id) {
        RuleName ruleName = ruleNameRepository.findOneById(id);
        return ruleName;
    }
    /**
     * delete a RuleName by its id
     * @param id int
     */
    public void deleteOneRuleNameById(int id) {
        ruleNameRepository.delete(findOneRuleNameById(id));
    }
    /**
     * save a RuleName
     * @param ruleName RuleName
     * @return RuleName
     */
    public RuleName saveRuleName(RuleName ruleName) {
        ruleName = ruleNameRepository.save(ruleName);
        return ruleName;
    }
    /**
     * update a RuleName
     * @param ruleName RuleName
     * @return RuleName
     */
    public RuleName updateRuleName(RuleName ruleName) {
        ruleNameRepository.updateRuleName(ruleName.getId(), ruleName.getName(), ruleName.getDescription(), ruleName.getJson(), ruleName.getTemplate(), ruleName.getSqlStr(), ruleName.getSqlPart());
        return ruleName;
    }

}
