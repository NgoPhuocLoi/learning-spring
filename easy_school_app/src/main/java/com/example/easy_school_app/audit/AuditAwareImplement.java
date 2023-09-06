package com.example.easy_school_app.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("auditAwareImplememnt")
public class AuditAwareImplement implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getCurrentAuditor'");
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());

    }

}
