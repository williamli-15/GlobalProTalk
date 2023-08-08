#!/bin/bash
set -x
awslocal s3 mb s3://cp-s3
KINESIS_STREAM_SHARDS=5
KINESIS_STREAM_NAME=cp-kinesis-stream
awslocal kinesis create-stream --shard-count ${KINESIS_STREAM_SHARDS} \
  --stream-name ${KINESIS_STREAM_NAME}
awslocal dynamodb create-table \
    --table-name Favorites \
    --attribute-definitions \
        AttributeName=user_id,AttributeType=S \
        AttributeName=post_id,AttributeType=S \
        AttributeName=timestamp,AttributeType=N \
    --key-schema \
        AttributeName=user_id,KeyType=HASH \
        AttributeName=post_id,KeyType=RANGE \
    --provisioned-throughput \
            ReadCapacityUnits=10,WriteCapacityUnits=5
set +x