/**
 * Copyright 2010-2016 Boxfuse GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flywaydb.core.internal.dbsupport.sqlserver;

import org.flywaydb.core.internal.dbsupport.Delimiter;
import org.flywaydb.core.internal.dbsupport.SqlStatementBuilder;

/**
 * SqlStatementBuilder supporting SQL Server-specific delimiter changes.
 */
public class SQLServerSqlStatementBuilder extends SqlStatementBuilder {
    @Override
    protected Delimiter getDefaultDelimiter() {
        return new Delimiter("GO", true);
    }

    @Override
    protected String cleanToken(String token) {
        if (token.startsWith("N'")) {
            return token.substring(token.indexOf("'"));
        }
        return super.cleanToken(token);
    }
}
