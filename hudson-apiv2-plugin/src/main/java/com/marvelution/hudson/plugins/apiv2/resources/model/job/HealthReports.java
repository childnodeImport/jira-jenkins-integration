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

package com.marvelution.hudson.plugins.apiv2.resources.model.job;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.marvelution.hudson.plugins.apiv2.resources.model.ListableModel;
import com.marvelution.hudson.plugins.apiv2.resources.utils.NameSpaceUtils;

/**
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
@XmlType(name = "HealthReportsType", namespace = NameSpaceUtils.JOB_NAMESPACE, factoryClass = ObjectFactory.class,
		factoryMethod = "createHealthReports")
@XmlRootElement(name = "HealthReports", namespace = NameSpaceUtils.JOB_NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthReports extends ListableModel<HealthReport> {

	@XmlElementRef
	private Collection<HealthReport> reports;

	/**
	 * Default Constructor
	 */
	public HealthReports() {
		this.reports = new ArrayList<HealthReport>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<HealthReport> getItems() {
		return reports;
	}

}
