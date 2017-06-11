/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package rbac.thymeleaf.shiro.dialect;


import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;
import rbac.thymeleaf.shiro.processor.attribute.*;
import rbac.thymeleaf.shiro.processor.element.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ShiroDialect extends AbstractDialect {
    private static final String PREFIX = "shiro";
    private static final Set<IProcessor> processors = new HashSet<IProcessor>();

    static {
        processors.add(PrincipalAttrProcessor.create());
        processors.add(PrincipalElementProcessor.create());

        processors.add(HasAllRolesAttrProcessor.create());
        processors.add(HasAllRolesElementProcessor.create());

        processors.add(HasAnyRolesAttrProcessor.create());
        processors.add(HasAnyRolesElementProcessor.create());

        processors.add(HasRoleAttrProcessor.create());
        processors.add(HasRoleElementProcessor.create());

        processors.add(LacksRoleAttrProcessor.create());
        processors.add(LacksRoleElementProcessor.create());

        processors.add(HasAllPermissionsAttrProcessor.create());
        processors.add(HasAllPermissionsElementProcessor.create());

        processors.add(HasAnyPermissionsAttrProcessor.create());
        processors.add(HasAnyPermissionsElementProcessor.create());

        processors.add(HasPermissionAttrProcessor.create());
        processors.add(HasPermissionElementProcessor.create());

        processors.add(LacksPermissionAttrProcessor.create());
        processors.add(LacksPermissionElementProcessor.create());

        processors.add(AuthenticatedAttrProcessor.create());
        processors.add(AuthenticatedElementProcessor.create());

        processors.add(NotAuthenticatedAttrProcessor.create());
        processors.add(NotAuthenticatedElementProcessor.create());

        processors.add(GuestAttrProcessor.create());
        processors.add(GuestElementProcessor.create());

        processors.add(UserAttrProcessor.create());
        processors.add(UserElementProcessor.create());
    }

    public ShiroDialect() {
        super();
    }

    public String getPrefix() {
        return PREFIX;
    }

    public boolean isLenient() {
        return false;
    }

    @Override
    public Set<IProcessor> getProcessors() {
        return Collections.unmodifiableSet(processors);
    }
}
