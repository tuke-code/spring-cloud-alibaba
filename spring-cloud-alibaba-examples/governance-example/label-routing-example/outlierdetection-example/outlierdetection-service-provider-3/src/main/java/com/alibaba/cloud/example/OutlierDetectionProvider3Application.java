/*
 * Copyright 2013-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.example;

import com.alibaba.cloud.nacos.registry.NacosRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xqw
 */

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class OutlierDetectionProvider3Application {

	public static void main(String[] args) {
		SpringApplication.run(OutlierDetectionProvider3Application.class, args);
	}

	@Autowired
	NacosRegistration nacosRegistration;

	@GetMapping("/test")
	public String test() {

		String host = nacosRegistration.getHost();
		int port = nacosRegistration.getPort();
		return "Route in " + host + ": " + port + ". ";
	}

}
