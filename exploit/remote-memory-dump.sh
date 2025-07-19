#!/bin/bash

set -euo pipefail
IFS=$'\n\t'

BASE='http://localhost:8080/schedule'

for ((i = 0; i < 2147483647; i++)); do
	b=$(\curl -fsSL "${BASE}/${i}")
	h=$(\printf "%016x" "${b}")
	\echo -n -e "\x${h:14:2}\x${h:12:2}\x${h:10:2}\x${h:8:2}\x${h:6:2}\x${h:4:2}\x${h:2:2}\x${h:0:2}"
done
