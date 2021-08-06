package com.nnk.springboot.services;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CurvePointService {

    @Autowired
    private CurvePointRepository curvePointRepository;
    /**
     *
     * @return all CurvePoint in a List<CurvePoint>
     */
    public List<CurvePoint> findAllCurvePoint() {
        List<CurvePoint> curvePoints = curvePointRepository.findAll();
        return curvePoints;
    }
    /**
     *
     * @param id int
     * @return CurvePoint
     */
    public CurvePoint findOneCurvePointById(int id) {
        CurvePoint curvePoint = curvePointRepository.findOneById(id);
        return curvePoint;
    }
    /**
     * delete a CurvePoint by its id
     * @param id int
     */
    public void deleteOneCurvePointById(int id) {
        curvePointRepository.delete(findOneCurvePointById(id));
    }
    /**
     * save a CurvePoint
     * @param curvePoint CurvePoint
     * @return CurvePoint
     */
    public CurvePoint saveCurvePoint(CurvePoint curvePoint) {
        curvePoint = curvePointRepository.save(curvePoint);
        return curvePoint;
    }
    /**
     * update a CurvePoint
     * @param curvePoint CurvePoint
     * @return CurvePoint
     */
    public CurvePoint updateCurvePoint(CurvePoint curvePoint) {
        int id = curvePoint.getId();
        curvePointRepository.updateCurvePoint(id, curvePoint.getCurveId(), curvePoint.getTerm(), curvePoint.getValue());
        return curvePoint;
    }

}
