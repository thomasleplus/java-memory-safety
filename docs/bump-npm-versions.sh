#!/bin/sh
# shellcheck shell=dash

set -euo pipefail

cd "$(\dirname "$0")"

\npx npm-check-updates -u

\npm install
