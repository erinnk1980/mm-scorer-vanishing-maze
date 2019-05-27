package com.topcoder.ReviewTest;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.topcoder.ReviewHelper.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			ReviewHelper reviewHelper = new ReviewHelper();

			// GET TOKEN
			// String token = reviewHelper.getToken();

			// GET REVIEWS
			// JSONArray reviews = reviewHelper.getReviews("30055011", token);
			// System.out.println(reviews);

			// JSONParser parser = new JSONParser();

			/**
			 * USE postReview method String res = postReview(String challengeId, String
			 * testPhase, String submissionId, String reviewerId, String typeId, String
			 * scoreCardId, List<Map<String,Object>> testScores)
			 */

			String challengeId = args[0];
			String testPhase = args[1];
			String submissionId = args[2];
			String reviewerId = args[3];
			String typeId = args[4];
			String scoreCardId = args[5];
			String exec = args[6];

			System.out.println(exec);

			// 10 Provisional tests, 100 system tests
			long startSeed = 1;
			long endSeed = 10;
			if (testPhase.equals("final")) {
				startSeed = 101;
				endSeed = 150;
			}

			List<Map<String, Object>> testScores = new ArrayList<Map<String, Object>>();
			// For now, try doing 10 tests and see how that works
			for (long i = startSeed; i <= endSeed; i++) {
				double score = VanishingMazeVis.main(new String[] { "-exec", exec, "-seed", i + "", "-novis" });
				HashMap res = new HashMap<String, Object>();
				res.put("score", score);
				res.put("testcase", i);
				testScores.add(res);
				String output = VanishingMazeVis.output.getOutput(); // Not quite sure what to do with this
			}

			// ReviewHelper.postReview(challengeId, testPhase, submissionId, reviewerId,
			// typeId, scoreCardId, testScores);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
