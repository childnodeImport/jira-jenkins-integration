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

package com.marvelution.hudson.plugins.apiv2.resources;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.marvelution.hudson.plugins.apiv2.resources.exceptions.NoSuchJobException;
import com.marvelution.hudson.plugins.apiv2.resources.model.job.Job;
import com.marvelution.hudson.plugins.apiv2.resources.model.job.Jobs;

/**
 * Job Resource Endpoint interface
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld<a/>
 */
public interface JobResource {

	/**
	 * Get the {@link Job} identified by the given name
	 * 
	 * @param name the name of the {@link Job} to get
	 * @param includeAllBuilds flag to include all the builds
	 * @return the {@link Job}
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 */
	@GET
	Job getJob(@QueryParam("name") String name,
					@QueryParam("includeAllBuilds") @DefaultValue("false") Boolean includeAllBuilds)
					throws NoSuchJobException;

	/**
	 * Get the status of a {@link Job} identified by the given name
	 * 
	 * @param name the name of the {@link Job} to get
	 * @param includeAllBuilds flag to include all the builds
	 * @return the {@link Job}
	 * @throws NoSuchJobException in case the job identified by the jobName doesn't exist
	 */
	@GET
	@Path("status")
	Job getJobStatus(@QueryParam("name") String name,
					@QueryParam("includeAllBuilds") @DefaultValue("false") Boolean includeAllBuilds)
					throws NoSuchJobException;

	/**
	 * Get all the {@link Job} objects on the Hudson server
	 * 
	 * @param includeAllBuilds flag to include all the builds
	 * @return the {@link Jobs} collection
	 */
	@GET
	@Path("all")
	Jobs getJobs(@QueryParam("includeAllBuilds") @DefaultValue("false") Boolean includeAllBuilds);

	/**
	 * Get all {@link Job} objects on the Hudson server, but with minimal data
	 * 
	 * @param nameOnly flag to include only names in the response, when set to <code>true</code>, this will override
	 *            the includeAllBuilds flag
	 * @param includeAllBuilds flag to include all the builds
	 * @return the {@link Jobs} collection
	 */
	@GET
	@Path("list")
	Jobs listJobs(@QueryParam("nameOnly") @DefaultValue("false") Boolean nameOnly,
					@QueryParam("includeAllBuilds") @DefaultValue("false") Boolean includeAllBuilds);

}
