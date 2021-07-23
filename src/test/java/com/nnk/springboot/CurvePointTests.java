package com.nnk.springboot;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.services.CurvePointService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointTests {

	@Autowired
	private CurvePointRepository curvePointRepository;
	@Autowired
	private CurvePointService curvePointService;

	@Test
	public void curvePointTest() {
		CurvePoint curvePoint = new CurvePoint(10, 10d, 30d);

		// Save
		curvePoint = curvePointService.saveCurvePoint(curvePoint);
		Assert.assertNotNull(curvePoint.getId());
		Assert.assertTrue(curvePoint.getCurveId() == 10);

		// Update
		curvePoint.setCurveId(20);
		curvePoint =curvePointService.updateCurvePoint(curvePoint);
		Assert.assertTrue(curvePoint.getCurveId() == 20);

		// Find
		List<CurvePoint> listResult = curvePointService.findAllCurvePoint();
		Assert.assertTrue(listResult.size() > 0);

		// Delete
		Integer id = curvePoint.getId();
		curvePointService.deleteOneCurvePointById(id);
		Optional<CurvePoint> curvePointList = curvePointRepository.findById(id);
		Assert.assertFalse(curvePointList.isPresent());
	}

}
