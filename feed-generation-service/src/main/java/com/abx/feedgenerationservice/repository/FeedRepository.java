package com.abx.feedgenerationservice.repository;

import com.abx.feedgenerationservice.model.FeedItem;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends CassandraRepository<FeedItem, UUID> {}
