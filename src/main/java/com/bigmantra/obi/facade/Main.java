package com.bigmantra.obi.facade;

import com.bigmantra.obi.proxy.v6.GetSubjectAreasResult;
import com.bigmantra.obi.proxy.v6.MetadataService;
import com.bigmantra.obi.proxy.v6.SAWSessionService;

public class Main {

	public static void main(String[] args) {

		SAWSessionService ss = new SAWSessionService();

		try {

			String sessionID = ss.logon("girish", "Password1");
			System.out.println("sessionId" + sessionID);
			MetadataService metaService =new MetadataService();
			GetSubjectAreasResult gsr=metaService.getSubjectAreas(sessionID);
			System.out.println(gsr.stream().findFirst().get().displayName);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
