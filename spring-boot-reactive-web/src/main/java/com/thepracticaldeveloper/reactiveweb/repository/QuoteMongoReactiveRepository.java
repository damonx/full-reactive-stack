/*
 * Copyright (c) Fisher and Paykel Appliances.
 *
 * This document is copyright. Except for the purpose of fair reviewing, no part
 * of this publication may be reproduced or transmitted in any form or by any
 * means, electronic or mechanical, including photocopying, recording, or any
 * information storage and retrieval system, without permission in writing from
 * the publisher. Infringers of copyright render themselves liable for
 * prosecution.
 */
package com.thepracticaldeveloper.reactiveweb.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.thepracticaldeveloper.reactiveweb.domain.Quote;

import reactor.core.publisher.Flux;

public interface QuoteMongoReactiveRepository extends ReactiveCrudRepository<Quote, String> {
	@Query("{ id: { $exists: true }}")
	Flux<Quote> retrieveAllQuotesPaged(final Pageable page);
}
