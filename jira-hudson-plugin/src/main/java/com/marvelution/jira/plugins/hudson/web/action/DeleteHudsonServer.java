/*
 * Licensed to Marvelution under one or more contributor license 
 * agreements.  See the NOTICE file distributed with this work 
 * for additional information regarding copyright ownership.
 * Marvelution licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.marvelution.jira.plugins.hudson.web.action;

import com.marvelution.jira.plugins.hudson.service.HudsonServer;
import com.marvelution.jira.plugins.hudson.service.HudsonServerManager;

/**
 * {@link AbstractHudsonWebActionSupport} implementation for deleting configured HUdson Servers
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
public class DeleteHudsonServer extends AbstractHudsonWebActionSupport {

	private static final long serialVersionUID = 1L;

	private int hudsonServerId;

	private HudsonServer hudsonServer;

	/**
	 * Constructor
	 * 
	 * @param hudsonServerManager the {@link HudsonServerManager} implementation
	 */
	public DeleteHudsonServer(HudsonServerManager hudsonServerManager) {
		super(hudsonServerManager);
	}

	/**
	 * {@inheritDoc}
	 */
	public String doDefault() throws Exception {
		hudsonServer = hudsonServerManager.getServer(hudsonServerId);
		return "input";
	}

	/**
	 * {@inheritDoc}
	 */
	public String doExecute() throws Exception {
		hudsonServerManager.remove(hudsonServerId);
		return getRedirect("ViewHudsonServers.jspa");
	}

	/**
	 * Get the {@link HudsonServer} Id
	 * 
	 * @return the {@link HudsonServer} Id
	 */
	public int getHudsonServerId() {
		return hudsonServerId;
	}

	/**
	 * Set the {@link HudsonServer} Id
	 * 
	 * @param hudsonServerId the {@link HudsonServer} Id
	 */
	public void setHudsonServerId(int hudsonServerId) {
		this.hudsonServerId = hudsonServerId;
	}

	/**
	 * Get the name of the {@link HudsonServer}
	 * 
	 * @return the name of the {@link HudsonServer}
	 */
	public String getName() {
		return hudsonServer.getName();
	}

}